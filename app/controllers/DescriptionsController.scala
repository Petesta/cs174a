package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._

import models.Description

object DescriptionsController extends Controller {
  val descriptionForm  = Form(
    tuple(
    "name" -> nonEmptyText,
    "value" -> nonEmptyText
    )
  )

  def newDescription = TODO
}
