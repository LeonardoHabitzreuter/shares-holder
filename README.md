## Sangria akka-http Example

An example [GraphQL](https://graphql.org) server written with [akka-http](https://github.com/akka/akka-http), [circe](https://github.com/circe/circe) and [sangria](https://github.com/sangria-graphql/sangria).

After starting the server with

```bash
sbt run

# or, if you want to watch the source code changes
 
sbt ~reStart
``` 

you can run queries interactively using [graphql-playground](https://github.com/prisma/graphql-playground) by opening [http://localhost:8080](http://localhost:8080) in a browser.


query {
	project(filter: {
		offset: Int
		myProject: Boolean
	}) {
		image: String
		name: String
		description: String
	}
}

query {
	user {
		name: String
		country: String
		state: String
	}
}