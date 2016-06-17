# spring-restdocs-with-gson

- This repository shows a problem related to spring-restdocs and GsonHttpMessageConverter.
- This [issue](https://github.com/spring-projects/spring-restdocs/issues/263) is currently opened, and planned to be solved.

- As spring-restdocs has compile dependency to jackson-databind, you need to state gson preference clearly for every gson config.

like this,

```xml
<!-- Rest Template common -->
<bean id="restTemplate" class="org.springframework.web.client.RestTemplate" >
	<constructor-arg>
		<bean class="org.springframework.http.client.HttpComponentsClientHttpRequestFactory" >
			<property name="readTimeout" value="1000"/>
			<property name="connectTimeout" value="1000"/>
		</bean>
	</constructor-arg>
	<property name="messageConverters">
		<list>
			<ref bean="gsonMessageConverter"/>
		</list>
	</property>
</bean>

<bean id="gsonMessageConverter" class="org.springframework.http.converter.json.GsonHttpMessageConverter"/>
```
