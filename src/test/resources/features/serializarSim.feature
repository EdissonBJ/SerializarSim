#language: es
@Serializacion
Característica: Serialización de SIM
  Como usuario autenticado en la aplicación
  Quiero poder serializar una SIM a partir de una orden
  Para confirmar la entrega de un recurso correctamente

  Antecedentes:
    Dado que el usuario se encuentre en la pagina web
    Y ingrese el usuario con la clave

  Escenario: Flujo exitoso de serialización de SIM
    Dado que el usuario se encuentre en serializar sim
    Cuando ingrese un número de orden válido desde el archivo Excel
    Y haga clic en consultar
    Y seleccione en el combo la opción "Venta de recurso"
    Y elija la opción "Ingresar SIM"
    Y registre una SIM válida desde el archivo Excel
    Y haga clic en aplicar
    Y vuelva a ingresar el número de orden en el campo de consulta
    Y haga clic en consultar
    Y seleccione en el combo la opción "Venta de recurso"
    Y haga clic en buscar
    Y haga clic en confirmar entrega
    Entonces el usuario visualizará el mensaje de "Entrega confirmada"

 # Escenario: Orden no encontrada
#    Cuando ingrese un número de orden inexistente desde el archivo Excel
 #   Y haga clic en consultar
  #  Entonces el sistema mostrará el mensaje "Orden no encontrada"

 # Escenario: SIM ya registrada
 #   Cuando ingrese un número de orden válido desde el archivo Excel
 #   Y haga clic en consultar
 #   Y seleccione en el combo la opción "Venta de recurso"
 #   Y elija la opción "Ingresar SIM"
  #  Y registre una SIM que ya fue utilizada previamente
 #   Y haga clic en aplicar
 #   Entonces el sistema mostrará el mensaje "La SIM ya se encuentra registrada"

 # Escenario: Confirmación de entrega fallida
 #   Cuando ingrese un número de orden válido desde el archivo Excel
 #   Y haga clic en consultar
 #   Y seleccione en el combo la opción "Venta de recurso"
 #   Y haga clic en buscar
  #  Y haga clic en confirmar entrega
 #  Entonces el sistema mostrará el mensaje "No es posible confirmar la entrega"
