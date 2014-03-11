package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._

import models.CartProduct

object CartProductsController extends Controller {
  val cartProductForm = Form(
    tuple(
      "qty" -> number,
      "productID" -> number
    )
  )

  def addProducts = Action { implicit request =>
    val cartOption = request.cookies.get("id")

    cartOption match {
      case Some(value) => {
        println(value.value.toInt)
        cartProductForm.bindFromRequest.fold(
          errors => BadRequest(views.html.customers.addProducts(cartProductForm)),
          {
            case (qty, productID) => {
              CartProduct.insertProduct(qty, productID, value.value.toInt)
              Redirect(routes.ManagersController.getSalesPerCategory)
            }
          }
        )
      }

      case None => NotFound // This is just a hack
    }
  }

  def cartProducts = Action { implicit request =>
    val cartOption = request.cookies.get("id")

    cartOption match {
      case Some(value) => {
        Ok(views.html.customers.cartProducts(CartProduct.listAllProducts(value.value.toInt)))
      }

      case None => NotFound // This is just a hack
    }
  }

  def deleteProducts(id: Int) = Action { implicit request =>
    val cartOption = request.cookies.get("id")

    cartOption match {
      case Some(value) => {
        CartProduct.deleteProduct(id, value.value.toInt)
        println(s"This is the ID that was deleted $id")
        Redirect(routes.CartProductsController.cartProducts)
      }

      case None => NotFound // This is just a hack
    }
  }
}
