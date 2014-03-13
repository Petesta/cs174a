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


  def about = Action { implicit request =>
    val user: Option[Customer] = Customer.findByEmail(request.session.get("email"))
    Ok(views.html.customers.about(user))
  }


  def newCustomer = Action {
    Ok(views.html.customers.newCustomer(customerForm)).withCookies(Cookie("id", Customer.findCustomerID()))
  }

  def createCustomer = Action { implicit request =>
    customerForm.bindFromRequest.fold(
      errors => BadRequest(views.html.customers.newCustomer(customerForm)),
      {
        case (depotID, firstName, lastName, email, password, street, status) => {
          Customer.create(depotID, firstName, lastName, email, password, street, status)
          Redirect(routes.ProductsController.list)
        }
      }
    ) 
  }
}

object Auth extends Controller {
  val loginForm = Form(
    tuple(
      "email" -> email,
      "password" -> text
    ) verifying ("Invalid email or password", result => result match {
      case (email, password) => check(email, password)
    })
  )

  def check(email: String, password: String) = {
    val customer = Customer.customerAuth(email, password)
    val tup = customer.map(f => (f.email, f.password))
    (email == tup(0)._1 && password == tup(0)._2)
  }

 def login = Action { implicit request =>
    Ok(views.html.customers.login(loginForm))
  }

  def authenticate = Action { implicit request =>
    loginForm.bindFromRequest.fold(
      errors => BadRequest(views.html.customers.login(errors)),
      user => Redirect(routes.ProductsController.list).withSession("email" -> user._1)
    )
  }

  def logout = Action {
    Redirect(routes.Auth.login).withNewSession.flashing(
      "success" -> "You are now logged out."
    )
  }
}
