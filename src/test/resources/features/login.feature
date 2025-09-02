#language: es
@Login
Característica: Login de usuario

  Escenario: Login de usuario exitoso
    Dado que el usuario se encuentre en la pagina web
    Cuando ingrese el usuario con la clave
    Entonces el usuario visualizara un mensaje de login exitoso

  Escenario: Login fallido por credenciales inválidas
    Dado que el usuario se encuentre en la pagina web
    Cuando ingrese el usuario con credenciales inválidas
    Entonces el sistema mostrará el mensaje "Credenciales incorrectas"

  Escenario: Usuario bloqueado
    Dado que el usuario se encuentre en la pagina web
    Cuando ingrese el usuario bloqueado con su clave
    Entonces el sistema mostrará el mensaje "Usuario bloqueado, contacte al administrador"
