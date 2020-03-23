# spring-boot-security
This sample project which demonstrates how to use spring security with spring boot.
Here inside HomeController there are several get mappings  as '/', '/user' and '/admin'.
/  mapping can be accessed by any user authority.
/user mapping can be only accesed by users who has ROLE_USER authority. 
/admin mapping can be only accesed by users who has ROLE_ADMIN authority. 
