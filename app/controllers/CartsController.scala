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
import models.Product
import models.CartProduct


object CartsController extends Controller {

  def checkout(cartID: Int) = Action { implicit request =>

    //get customer id according cart
    val cart = Cart.getById(cartID)
    println(cart)
    var customerId = cart(0).customerID
    println("customer: " + customerId)

    // get all products from chartproducts
    val productsInCart = CartProduct.getAllByCart(cartID)

    // crate new order
    Order.insert(customerId)
    val latestOrder = Order.getLatest(customerId)
    var orderId = latestOrder(0).id

    // create for each product in cartProducts an new orderproduct and append to order
    productsInCart.foreach(x => println(x))
    productsInCart.foreach( productInChart =>
      OrdersProduct.insertProduct(productInChart.qty, Product.getById(productInChart.productID)(0).price, productInChart.productID, orderId)
    )

    //delete products in cart
    productsInCart.foreach( productInChart =>
      CartProduct.deleteProduct(productInChart.id, customerId)
    )

    Redirect(routes.OrdersController.list())
  }

}
