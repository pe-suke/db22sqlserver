# db22sqlserver
## JDBC Driverについて

1. DB2とSQL ServerのJDBC DriverはMavenのリポジトリにはないため、以下から入手してください。  

    * DB2 : http://www-01.ibm.com/support/docview.wss?uid=swg21363866  
    * SQL Server : https://www.microsoft.com/ja-jp/download/details.aspx?id=11774  

1. 以下のmvnコマンドでMavenローカルリポジトリにインストールして下さい。  

    `mvn install:install-file -Dfile=sqljdbc42.jar -DgroupId=com.microsoft.sqlserver -DartifactId=sqljdbc42 -Dversion=4.2.6420.100 -Dpackaging=jar`
    
    `mvn install:install-file -Dfile=db2jcc4 -DgroupId=com.ibm.db2.jcc -DartifactId=db2jcc4 -Dversion=4.0 -Dpackaging=jar`

    ※上記コマンドは、pom.xmlに合わせてあります。

