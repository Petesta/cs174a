package models

import anorm._
import anorm.SqlParser._

import play.api.db._
import play.api.Play.current

case class Description(id: Int, name: String, value: String, catProductID: Int)

object Description {
  val description = {
    get[Int]("id") ~
    get[String]("name") ~
    get[String]("value") ~
    get[Int]("catProductID") map {
      case id~name~value~catProductID => Description(id, name, value, catProductID)
    }
  }

  def create(name: String, value: String) {
    // TODO: We'll probably need to get a FOREIGN KEY value for catProductID
    DB.withConnection { implicit c =>
      SQL("insert into descriptions(name, value) values ({name, value})").on(
        'name -> name,
        'value -> value
      ).executeInsert()
    }
  }
}
