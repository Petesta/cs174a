package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._

import models.OrdersProduct

object OrdersProductsController extends Controller {
  val ordersProductForm = Form(
    tuple(
      "qty" -> number,
      "priceBuy" -> bigDecimal
    )
  )

  def newOrdersProduct = TODO
}
