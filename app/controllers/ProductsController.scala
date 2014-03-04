package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._

import models.Product

object ProductsController extends Controller {
  val productForm = Form(
    "stockNumber" -> nonEmptyText
  )

  def getProducts = Action {
    Ok(views.html.managers.sales(Product.all()))
  }

}
