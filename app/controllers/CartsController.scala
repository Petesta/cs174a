package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._

import models.Customer
import models.Cart
import models.CartProduct
import models.Order
import models.OrdersProduct


object CartsController extends Controller {

  def checkout(cartID: Int) = Action { implicit request =>
    val customers = Customer.getAll()
    customers.foreach(x => println(x))

    //get customer id according cart
    val cart = Cart.getById(cartID)
    val allCharts = Cart.listAllCarts()
    allCharts.foreach(x => println(x))
    var customerId = cart(0).customerID
    println("customer: " + customerId)

    // get all products from chartproducts
    val productsInCart = CartProduct.listAllProducts(cartID)

    // crate new order
    Order.insert(customerId)
    val latestOrder = Order.getLatest(customerId)
    var orderId = latestOrder(0).id

    // create for each product in cartProducts an new orderproduct and append to order
    productsInCart.foreach(x => println(x))
    productsInCart.foreach( productInChart =>
      OrdersProduct.insertProduct(productInChart.qty, 13.3, productInChart.id, orderId)
    )

    //TODO: delete cartproducts

    Redirect(routes.OrdersController.list(customerId))
  }

}
