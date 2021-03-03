# javasupport
```
基于jdk1.8 封装的类库、算法、常用方法等，本项目无外包jar包依赖，仅依赖原生jdk1.8代码库

```

## 引入jar包
```
<dependency>
    <groupId>com.nfangbian.javasupport</groupId>
    <artifactId>javasupport</artifactId>
    <version>1.0.0</version>
</dependency>

调用示例：
import com.nfangbian.javasupport.utils.StringUtils;
System.out.println(StringUtils.toStringIgnoreNull(new String("hello")));

```


## 发布到远程仓库
```
打包： mvn clean package
发布：
mvn deploy:deploy-file \
  -DgroupId=com.nfangbian.javasupport \
  -DartifactId=javasupport \
  -Dversion=1.0.0 \
  -Dpackaging=jar \
  -Dfile=/Users/jelly/javasupport/target/javasupport-1.0.0.jar \
  -Durl=http://nexus的域名:8081/repository/maven-releases/ \
  -DrepositoryId=releases

把其中-Dfile值改成你真实的jar位置
    -Durl值改成你的私服地址
    -DrepositoryId值改成对应settings.xml文件中servers.server.id节点值，节点配置值示例如下：
    <server>
      <id>releases</id>
      <username>admin</username>
      <password>admin123</password>
    </server>

```
