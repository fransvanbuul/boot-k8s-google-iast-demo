# boot-k8s-google-iast-demo

Small demo of running IAST technology in combination with Spring Boot, Kubernetes and Google Identity / ReCaptcha

The application has an intentional reflected XSS vulnerability in /testpage, which is easily found using WebInspect..

Because /testpage is behind Google Login, WebInspect will only find this if you provide it with a login macro to allow it to login.

