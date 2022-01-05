## server-side-d11

1. `mvn spring-boot:run`
2. terminate spring boot process
3. `heroku login`
4. `heroku create`
5. `git init`
6. `git remote-v`, if this returns blank, run step 7, else skip to step 8
7. `git remote add heroku <heroku git url>`
8. git add.
9. git commit -m"new"
10. add a new file under workshop 11 root directory named system.properties.
    Append the below in the file:
    `java.runtime.version=17`
11. `git push origin main` (Note: from one level above root folder)
12. `git subtree push --prefix workshop11 heroku main` (Note: from one level above root folder)
13. copy the url of heroku and paste to the browser
14. `git remote add origin` <git repo url>
15. To run with command line (only works with command prompt and not bash):

    `mvn spring-boot:run -Dspring-boot.run.arguments=--port=8081`
