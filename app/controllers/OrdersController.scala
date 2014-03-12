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

  def list(customerId: Int) = Action {
    Ok(views.html.orders.list(Order.getAllByCustomer(customerId)))
  }

  def detail(orderId: Int) = Action {
    Ok(views.html.orders.detail(OrdersProduct.getAllByOrder(orderId)))
  }

}
