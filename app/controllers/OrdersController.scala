package controllers

import java.util.{Date}

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._

import models.Order
import models.OrdersProduct
import models.Customer
import models.Product

object OrdersController extends Controller {

  def list() = Action { implicit request =>
    val customer = Customer.findByEmail(request.session.get("email"));

    customer match {
      case Some(value) => {
        Ok(views.html.orders.list(Order.getAllByCustomer(value.id)))
      }

      case None => NotFound // This is just a hack
    }
  }

  def detail(orderId: Int) = Action { implicit request =>
    Ok(views.html.orders.detail(OrdersProduct.getAllByOrder(orderId)))
  }

  def rerun(orderId: Int) = Action { implicit request =>
    val customer = Customer.findByEmail(request.session.get("email"));

    customer match {
      case Some(value) => {
        val customerId = value.id
        var orderProducts = List[OrdersProduct]()

          // get all products
        orderProducts = OrdersProduct.getAllByOrder(orderId)

        //create order and save id from created order
        Order.insert(customerId)
        val latestOrder = Order.getLatest(customerId)
        var latestOrderId = latestOrder(0).id

        //insert every orderproduct and assign to order
        orderProducts.foreach(x => println(x))
        orderProducts.foreach( orderProduct =>
          OrdersProduct.insertProduct(orderProduct.qty, Product.getById(orderProduct.productID)(0).price, orderProduct.productID, latestOrderId)
        )

        Redirect(routes.OrdersController.list())
      }

      case None => NotFound // This is just a hack
    }

  }
}
