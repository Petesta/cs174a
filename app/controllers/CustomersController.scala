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
      "depotID" -> nonEmptyText,
      "firstName" -> nonEmptyText,
      "lastName" -> nonEmptyText,
      "email" -> email,
      "password" -> nonEmptyText,
      "street" -> nonEmptyText,
      "status" -> nonEmptyText
    )
  )

  def newCustomer = Action {
    Ok(views.html.customers.newCustomer(customerForm))
  }

  def createCustomer = Action { implicit request =>
    customerForm.bindFromRequest.fold(
      errors => BadRequest(views.html.customers.newCustomer(customerForm)),
      {
        case (depotID, firstName, lastName, email, password, street, status) => {
          Customer.create(depotID, firstName, lastName, email, password, street, status)
          Redirect(routes.ManagersController.getSalesPerCategory)
        }
      }
    ) 
  }
}
