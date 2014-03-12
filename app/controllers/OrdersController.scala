package controllers

import java.util.{Date}

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._

import models.Order
import models.OrdersProduct

object OrdersController extends Controller {
  def newOrder = TODO
  
  /*
  def cartProducts = Action { implicit request =>
    val cartOption = request.cookies.get("id")

    cartOption match {
      case Some(value) => {
        Ok(views.html.customers.cartProducts(CartProduct.listAllProducts(value.value.toInt)))
      }

      case None => NotFound // This is just a hack
    }
  }
  */

  def previousOrder = Action { implicit request =>
    val cartOption = request.cookies.get("id")

    cartOption match {
      case Some(value) => {
        Ok(views.html.customers.previousOrder(Order.findPreviousOrder(value.value.toInt))) 
      }

      case None => NotFound // This is just a hack
    }
  }

  def list(customerId: Int) = Action {
    Ok(views.html.orders.list(Order.getAllByCustomer(customerId)))
  }

  def detail(orderId: Int) = Action {
    Ok(views.html.orders.detail(OrdersProduct.getAllByOrder(orderId)))
  }
}
