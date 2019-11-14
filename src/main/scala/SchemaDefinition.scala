import sangria.execution.deferred.{Fetcher, HasId}
import sangria.schema._

import scala.concurrent.Future

/**
  * Defines a GraphQL schema for the current project
  */
object SchemaDefinition {

  /**
    * Resolves the lists of characters. These resolutions are batched and
    * cached for the duration of a query.
    */
  val projects = Fetcher.caching(
    (ctx: ProjectsRepo, ids: Seq[String]) ⇒
      Future
        .successful(ids.flatMap(id ⇒ ctx.getProject(id)))
  )(HasId(_.id))

  val Project = ObjectType(
    "Project",
    fields[ProjectsRepo, Project](
      Field(
        "id",
        StringType,
        Some("Id"),
        resolve = _.value.id
      ),
      Field(
        "name",
        StringType,
        Some("Name"),
        resolve = _.value.name
      ),
      Field(
        "description",
        StringType,
        Some("Description"),
        resolve = _.value.description
      ),
      Field(
        "image",
        StringType,
        Some("Image"),
        resolve = _.value.image
      )
    )
  )

  val ID = Argument("id", StringType, description = "id of the character")
  val OffsetArg = Argument("offset", OptionInputType(IntType), defaultValue = 0)

  val Query = ObjectType(
    "Query",
    fields[ProjectsRepo, Unit](
      Field(
        "project",
        OptionType(Project),
        arguments = OffsetArg :: Nil,
        resolve = ctx ⇒ ctx.ctx.getProject(ctx arg OffsetArg)
      )
    )
  )

  val ProjectsSchema = Schema(Query)
}
