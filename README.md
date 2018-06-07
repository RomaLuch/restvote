**Установка**
1) клонируем проект с гитхаба https://github.com/RomaLuch/restvote
2) собираем проект выполнив (в папке с проектом ) команду в консоли:
 
 mvn install
 
 или, чтобы запустить без тестов:
 
 mvn install -Dmaven.test.skip=true
 
3) файл restvote.war деплоим в tomcat (проверялось на версии apache-tomcat-9.0.0.M18)

**Использование**

Для доступа к get html запросам можно использовать адресную строку браузера 

http://localhost:8080/restvote/

предварительно потребуется авторизоваться:
используйте:
1) login = user@yandex.ru password= password, для авторизации как пользователь
2) login = admin@gmail.com password= admin, для авторизации как администратор

после авторизации из браузера для обоих видов пользователя будут доступны get запросы 
1) http://localhost:8080/restvote/users возвращает список всех пользоватлей
2) http://localhost:8080/restvote/restaurants возвращает список всех ресторанов
3) http://localhost:8080/restvote/menu/100000 возвращает меню ресторана с указаным id

для доступа к post, delete, put запросам потребуется
 - или установка SoapUI (https://www.soapui.org/).
Настроенную xml конфигурацию запросов можно взять из файла SOUP-REST-TEST.xml в папке config проекта
- или использование curl команд, из командной строки (примеры команд вы найдете в файле curl.md в папке config проекта)
