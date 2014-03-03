package models

import anorm._
import anorm.SqlParser._

import play.api.db._
import play.api.Play.current

case class Category(id: Int, name: String)

object Category {
  val category = {
    get[Int]("id") ~
    get[String]("name") map {
      case id~name => Category(id, name)
    }
  }

  def create(name: String) {
    DB.withConnection { implicit c =>
      SQL("insert into category (name) values ({name})").on(
        'name -> name
      ).executeInsert()
    }
  }
}
