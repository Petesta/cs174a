package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._

import models.Model

object ModelsController extends Controller {
  val modelForm = Form(
    "modelNumber" -> nonEmptyText
  )

  def newManufacturer = TODO
}
