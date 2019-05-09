
### lib下jar包下载地址
[用到的jar包]("https://repo.spring.io/libs-release-local/org/springframework/spring/")
[而不是源码包](https://repo.spring.io/libs-release-local/org/springframework/spring/)
- Project Structure添加上面的lib
- 然后右击 Add Framework Support -> spring,它会自己找到我们导入的bean包
这一步后可以创建spring config xml
---
### Common logging 实现类查找
1. 首先在classpath下寻找自己的配置文件commons-logging.properties，如果找到，则使用其中定义的Log实现类
2. 如果找不到commons-logging.properties文件，则在查找是否已定义系统环境变量org.apache.commons.logging.Log，找到则使用其定义的Log实现类
3. 否则，查看classpath中是否有Log4j的包，如果发现，则自动使用Log4j作为日志实现类
4. 否则，使用JDK自身的日志实现类（JDK1.4以后才有日志实现类）
5. 否则，使用commons-logging自己提供的一个简单的日志实现类SimpleLog