package models

import anorm._
import anorm.SqlParser._

import play.api.db._
import play.api.Play.current

case class Model(id: Int, modelNumber: String, companyID: Int)

object Model {
  val model = {
    get[Int]("id") ~
    get[String]("modelNumber") ~
    get[Int]("companyID") map {
      case id~modelNumber~companyID => Model(id, modelNumber, companyID)
    }
  }

  def create(modelNumber: String) {
    // TODO: We'll probably need to get a FOREIGN KEY value
    DB.withConnection { implicit c =>
      SQL("insert into models (modelNumber) values ({modelNumber})").on(
        'companyName -> companyName
      ).executeInsert()
    }
  }
}
