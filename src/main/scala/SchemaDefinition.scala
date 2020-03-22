import sangria.execution.deferred.{Fetcher, HasId}
import sangria.schema._
import modules.project._
import modules.user._
import TypeDefs._
import scala.concurrent.Future
import sangria.macros.derive._

object SchemaDefinition {
  implicit val UserType = deriveObjectType[Context, User]()
  implicit val ProjectType = deriveObjectType[Context, Project]()

  case class Context(mutation: Mutation, query: Query)

  val MutationType = deriveContextObjectType[Context, Mutation, Unit](_.mutation)
  val QueryType = deriveContextObjectType[Context, Query, Unit](_.query)

  val ProjectsSchema = Schema(QueryType, Some(MutationType))
}
