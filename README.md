# API Library
## Endpoints: 
- GET http://localhost:8080/api/authors
- GET http://localhost:8080/api/books
- POST http://localhost:8080/api/books/add

{
"name" : "book",
"isbn": 123
}

- POST http://localhost:8080/api/authors/add

{
"name": "Author",
"authorBooks":
[ {
"name" : "Book",
"isbn": 123
} ] }

- PATCH http://localhost:8081/api/authors/update/{UUID}

{
"name": "Author",
"authorBooks":
[ {
"name" : "Book",
"isbn": 123
} ] }

- PATCH http://localhost:8081/api/books/update/{UUID}


{
"name" : "book",
"isbn": 123
}

- DEL http://localhost:8081/api/authors/delete/{UUID}
- DEL http://localhost:8081/api/books/update/{UUID}