package models

import anorm._
import anorm.SqlParser._

import play.api.db._
import play.api.Play.current

case class Manufacturer(id: Int, companyName: String)

object Manufacturer {
  val manufacturer = {
    get[Int]("id") ~
    get[String]("companyName") map {
      case id~companyName => Manufacturer(id, companyName)
    }
  }

  def create(companyName: String){
    DB.withConnection { implicit c =>
      SQL("insert into manufacturers (companyName) values ({companyName})").on(
        'companyName -> companyName
      ).executeInsert()
    }
  }
}
