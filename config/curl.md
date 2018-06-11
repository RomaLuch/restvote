### curl samples (application deployed in application context `topjava`).
> For windows use `Git Bash`

#### get All Users
`curl -s http://localhost:8080/restvote/users --user admin@gmail.com:admin`

#### get Users 100003
`curl -s http://localhost:8080/restvote/users/100003 --user admin@gmail.com:admin`

#### delete User 100003
`curl -s -X DELETE http://localhost:8080/restvote/users/100003 --user admin@gmail.com:admin`

#### create User
`curl -s -X POST -d ' {
       "name": "CREATED",
       "email": "CREATED@yandex.ru",
       "password": "CREATEDpassword",
       "roles": ["ROLE_USER"]
    }' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/restvote/users --user admin@gmail.com:admin
`
#### update User
`curl -s -X PUT -d ' {
       "id": 100003,
       "name": "NEW USER",
       "email": "NEWUSER@yandex.ru",
       "password": "NEWpassword",
       "roles": ["ROLE_USER"]
    } ' -H 'Content-Type: application/json' http://localhost:8080/restvote/users/100003 --user user@yandex.ru:password
`

#### get All Restaurants
`curl -s http://localhost:8080/restvote/restaurants --user admin@gmail.com:admin`

#### get Restaurant 100002
`curl -s http://localhost:8080/restvote/restaurants/100002 --user admin@gmail.com:admin`

#### try update Restaurant 100002 (Access is denied)
`curl -s -X PUT -d ' {
         "id": 100002,
         "name": "Updated_Name",
         "adress": "Updated_adress"
    } ' -H 'Content-Type: application/json' http://localhost:8080/restvote/restaurants/100002 --user user@yandex.ru:password
`

#### update Restaurant 100002 (Access only to Admin)
`curl -s -X PUT -d ' {
         "id": 100002,
         "name": "Updated_Name",
         "adress": "Updated_adress"
    } ' -H 'Content-Type: application/json' http://localhost:8080/restvote/restaurants/100002 --user admin@gmail.com:admin
`

#### try delete Restaurant 100002 (Access is denied)
`curl -s -X DELETE http://localhost:8080/restvote/restaurants/100002 --user user@yandex.ru:password`

#### try delete Restaurant 100002 (Access only to Admin)
`curl -s -X DELETE http://localhost:8080/restvote/restaurants/100002 --user admin@gmail.com:admin`

####  create Restaurant (Access is denied)
`curl -s -X POST -d ' {
           "name": "NEW_NAME",
           "adress": "NEW_Adress"
     }' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/restvote/restaurants --user user@yandex.ru:password
`

####  create Restaurant (Access only to Admin)
`curl -s -X POST -d ' {
           "name": "NEW_NAME",
           "adress": "NEW_Adress"
     }' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/restvote/restaurants --user admin@gmail.com:admin
`

#### get All Menu to restaurant with id = 100002
`curl -s http://localhost:8080/restvote/menu/100002 --user admin@gmail.com:admin`

#### get Menu with Id 100005 to restaurant with id
`curl -s http://localhost:8080/restvote/menu/100002/100005 --user admin@gmail.com:admin`

#### try update Menu 100005 (Access is denied)
`curl -s -X PUT -d ' {
                        "id": 100005,
                        "name": "Updated_name",
                        "price": 777
                     } ' -H 'Content-Type: application/json' http://localhost:8080/restvote/menu/100000/100005 --user user@yandex.ru:password
`

#### update Menu 100005 (Access only to Admin)
`curl -s -X PUT -d ' {
                        "id": 100005,
                        "name": "Updated_name",
                        "price": 777
                     } ' -H 'Content-Type: application/json' http://localhost:8080/restvote/menu/100000/100005 --user admin@gmail.com:admin
`

#### try delete Menu 100005 (Access is denied)
`curl -s -X DELETE http://localhost:8080/restvote/menu/100000/100005 --user user@yandex.ru:password`
#### delete Menu 100005 (Access only to Admin)
`curl -s -X DELETE http://localhost:8080/restvote/menu/100000/100005 --user admin@gmail.com:admin`

#### try create Menu (Access is denied)
`curl -s -X POST -d ' {
                            "name": "sashimi",
                            "price": 500
                         }' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/restvote/menu/100000 --user user@yandex.ru:password
`

####  create Menu (Access only to Admin)
`curl -s -X POST -d ' {
                            "name": "sashimi",
                            "price": 500
                         }' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/restvote/menu/100000 --user admin@gmail.com:admin
`

####  create Vote to restaurant 100002 (You can not voting beatween 10:00 and 18:00)
`curl -s -X POST http://localhost:8080/restvote/vote/100000 --user admin@gmail.com:admin
`
