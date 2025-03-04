# javasupport
```
基于jdk1.8 封装的类库、算法、常用方法等，本项目无外包jar包依赖，仅依赖原生jdk1.8代码库

```

## 引入jar包
```
1、引入包
<dependency>
    <groupId>com.jellycheng.javasupport</groupId>
    <artifactId>javasupport</artifactId>
    <version>1.0.0</version>
</dependency>

2、调用示例：
import com.jellycheng.javasupport.utils.StringUtils;

public class Cjs {
    public static void main(String[] arg) {
        System.out.println(StringUtils.boolean2String(true));  // 打印字符串 1
        System.out.println(StringUtils.boolean2String(false)); // 打印字符串 0
    }
}


```


## 发布到远程仓库
```
1、打包生成jar文件： mvn clean package
2、发布本地jar文件到远程：
mvn deploy:deploy-file \
  -DgroupId=com.jellycheng.javasupport \
  -DartifactId=javasupport \
  -Dversion=1.0.0 \
  -Dpackaging=jar \
  -Dfile=/您的绝对目录/javasupport/target/javasupport-1.0.0.jar \
  -Durl=http://nexus的域名:8081/repository/maven-releases/ \
  -DrepositoryId=releases

其中 -Dfile值改成你真实的jar位置
    -Durl值改成你的私服地址
    -DrepositoryId值改成对应settings.xml文件中servers.server.id节点值，节点配置值示例如下：
    <server>
      <id>releases</id>
      <username>admin</username>
      <password>admin123</password>
    </server>

```

## 仅放入本地maven仓库
```
mvn install:install-file \
  -Dfile=/您的绝对路径/javasupport/target/javasupport-1.0.0.jar \
  -DgroupId=com.jellycheng.javasupport \
  -DartifactId=javasupport \
  -Dversion=1.0.0 \
  -Dpackaging=jar

其中： 
    -Dfile值为jar文件路径
    -DgroupId、-DartifactId、-Dversion 用于指定坐标
    -Dpackaging=jar 固定写法

或者 在 javasupport工程目录下执行： mvn clean install

```

## 签名算法示例
```
package demo;

import com.jellycheng.javasupport.utils.ApiSign;
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

## Aes加解密算法
```
import com.jellycheng.javasupport.utils.Aes;

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
        // 解密
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

## Des加解密算法
```
import com.jellycheng.javasupport.utils.DESUtils;

public class CjsDemo {
    public static void main(String[] arrg) {
        String desKey = "f8k3f5x6f8g2er68";
        String desIV  = "12345678";
        String str1 = "{\"code\":0,\"msg\":\"success\",\"data\":{\"tips\":\"无线Api正常\",\"cloud_name\":false},\"trace_id\":\"0187989ccf93525400e908c82bce0000\"}";
        String res1 = DESUtils.encrypt(desIV, desKey, str1); //加密
        System.out.println(res1);
        
        String res2 = DESUtils.decrypt(desIV, desKey, res1); //解密
        System.out.println(res2);
    }
}

```

## 枚举类管理异常code思路
```
import com.jellycheng.javasupport.exception.ExceptionCode;

public class Cjs {
    public static void main(String[] arg) {
        System.out.println(ExceptionCode.NOT_LOGIN.getCode());// 100
        System.out.println(ExceptionCode.NOT_LOGIN.getMsg()); // 未登录
        ExceptionCode.NOT_LOGIN.editMsg("请你登录:%s", "张三");
        System.out.println(ExceptionCode.NOT_LOGIN.getMsg()); //请你登录:张三
        ExceptionCode.DEFINE_ERROR.formatMsg("通用自定义错误");
        System.out.println(ExceptionCode.DEFINE_ERROR.getMsg());//通用自定义错误
    }
}

```
