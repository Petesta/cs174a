package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._

import models.Customer

object CustomersController extends Controller {
  val customerForm = Form(
    tuple(
      "firstName" -> nonEmptyText(maxLength = 10),
      "lastName" -> nonEmptyText(maxLength = 10),
      "email" -> email,
      "password" -> nonEmptyText(minLength = 5, maxLength = 10),
      "street" -> nonEmptyText(maxLength = 10),
      "zip" -> nonEmptyText(maxLength = 10),
      "city" -> nonEmptyText(maxLength = 10)
    )
  )

  /*def newCustomer = Action {
    Ok(views.html.customers.newCustomer(customerForm))
  }*/

  /*
  def createCustomer = Action { implicit request =>
    customerForm.bindFromRequest.fold(
      error => BadRequest(views.html.customers.newCustomer(customerForm)),
      {
        case (firstName, lastName, email, password, street, zip, city) => {
          Customer.create(firstName, lastName, email, password, street, zip, city)
          Redirect(routes.CustomersController.newCustomer)
        }
      }
    ) 
  }*/
}
