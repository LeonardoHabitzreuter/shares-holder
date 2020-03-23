package modules.user

import scala.concurrent.duration.Duration
import scala.concurrent.Await
import slick.jdbc.PostgresProfile.api._

object UserMutations {
  def create(email: String, password: String): String = {
    val connectionUrl = "jdbc:postgresql://localhost/shares?user=postgres&password=holder07"

    val users = TableQuery[Users]
    val db = Database.forURL(connectionUrl, driver = "org.postgresql.Driver")

    try {
      Await.result(db.run(DBIO.seq(
        users += User(email, password)
      )), Duration.Inf)
      "1"
    } finally db.close
  }
}
