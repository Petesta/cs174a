package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._

import models.Manufacturer

object ManufacturersController extends Controller {
  val manufacturerForm = Form(
    "companyName" -> nonEmptyText(maxLength = 10)
  )

  def newManufacturer = TODO
}
