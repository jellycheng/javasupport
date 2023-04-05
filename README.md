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

## 签名算法示例
```
package demo;

import com.nfangbian.javasupport.utils.ApiSign;
import java.util.HashMap;
import java.util.Map;

public class CjsDemo {
    public static void main(String[] arrg) {
        ApiSign apiSign = ApiSign.getInstance();
        apiSign.setSecret("abc123$%^cjs789xyz");
        Map<String, Object> data = new HashMap<String, Object>();
            data.put("a", 123);
            data.put("b", false);
            data.put("b1", true);
            data.put("c", 0);
            data.put("c1", "");
            data.put("c2", null);
            data.put("d", 222.2);
            data.put("e2", 0.1);
            data.put("e4", "你好，我是xxx");
            data.put("e0", 888);
        apiSign.setData(data);
        String sign = apiSign.makeSign();
        System.out.println(sign);

    }
}

```

## 加解密算法
```
package demo;

import com.nfangbian.javasupport.utils.Aes;

public class CjsDemo {
    public static void main(String[] arrg) {
        String appKey = "helloWorld1234";
        String str1 = "{\"chn\": \"baidu\",\"phone\": \"13712345678\",\"timestamp\": \"1680694802\",\"biz_type\": 1}";
        String res1 = "";
        // 加密
        try {
            res1 = Aes.encrypt(str1, appKey);
            System.out.println(res1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String str2 = res1;
            String res2 = Aes.decrypt(str2, appKey);
            System.out.println(res2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

```
