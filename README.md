# Mantenedor de Tareas

1. Para desplegar la aplicacion se requiere docker instalado, al ingresar en la ruta tarea se encuentra la aplicación en SPRINGBOOT para despelgar se debe ejecutar el siguiente comando: **docker-compose -f docker-compose.yml up -d** el cual levantara la base de datos y el backend en el puerto 8088.

   Se puede acceder a la descripcion del recurso en **http://localhost:8088/swagger-ui/index.html**.

   ![image](https://user-images.githubusercontent.com/25494881/135249720-66118018-3de1-406c-8031-2f3adec23451.png)


2. Para desplegar la aplicacion de front en react se debe ubicar en la ruta tarea_fe primero ejecuta **npm install**. En esta debe ejecutar **docker build -t tareas_front .** para crear la imagen con el build del contenedor y luego ejecutar **docker run -p 3000:3000 --name tareas_front -d tareas_front** para desplegar el front en el puerto 3000.



3. Con los pasos anteriormente realizados ya se encuentra desplegada la aplicion completa.

   ![image](https://user-images.githubusercontent.com/25494881/135250176-9f1ae267-0b7d-4f93-87c0-c22538d421a9.png)
   ![image](https://user-images.githubusercontent.com/25494881/135250325-c951bb48-bd43-4be2-9102-5c4c2c9a8587.png)


