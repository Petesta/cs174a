package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._

import models.Cart
import models.CartProduct
import models.Customer

object CartProductsController extends Controller {
  val cartProductForm = Form(
    tuple(
      "qty" -> number,
      "productID" -> number
    )
  )

  def addProducts = Action { implicit request =>
    val customer = Customer.findByEmail(request.session.get("email"));

    customer match {
      case Some(value) => {
        cartProductForm.bindFromRequest.fold(
          errors => BadRequest(views.html.customers.addProducts(cartProductForm)),
          {
            case (qty, productID) => {
              CartProduct.insertProduct(qty, productID, value.id)
              Redirect(routes.ManagersController.getSalesPerCategory)
            }
          }
        )
      }

      case None => NotFound // This is just a hack
    }
  }

  def cartProducts = Action { implicit request =>
    val customer = Customer.findByEmail(request.session.get("email"));

    customer match {
      case Some(value) => {
        Ok(views.html.customers.cartProducts(CartProduct.listAllProducts(value.id), value))
      }

      case None => NotFound // This is just a hack
    }
  }

  def deleteProducts(id: Int) = Action { implicit request =>
    val customer = Customer.findByEmail(request.session.get("email"));

    customer match {
      case Some(value) => {
        CartProduct.deleteProduct(id, value.id)
        println(s"This is the ID that was deleted $id")
        Redirect(routes.CartProductsController.cartProducts)
      }

      case None => NotFound // This is just a hack
    }
  }
}
