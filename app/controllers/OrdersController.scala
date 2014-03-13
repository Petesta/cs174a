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
}
