package com.ucn.programacion.talleres.taller001;

import ucn.ArchivoEntrada;
import ucn.Registro;
import ucn.StdOut;

public interface SistemaMab {
    /**
     * Registra un usuario indicando su nombre, apellido paterno, apellido materno, rut, nombre de usuario y clave. El
     * usuario  no debe estar repetido y además cada usuario nuevo no tendrá ninguna membresía asignada.
     *
     * @param nombre         nombre con el cual se identifica la persona.
     * @param apellidoP      apellido paterno con el cual se identifica la persona.
     * @param apellidoM      apellido materno con el cual se identifica la persona.
     * @param rut            numero de registro unico tributario la cual se identifica a la persona y es unico.
     * @param nombreUsuario  nombre de usuario que elige el usuario para ser identificado dentro del sistema.
     * @param password       conjunto de caracteres que permite loguear al usuario de manera segura.
     * @return boolean de valor true si el registro de usuario se efectuo exitosamente, en caso contrario regresa
     * un false si el registro no fue realizado.
     */
    boolean registrarUsuario(String nombre, String apellidoP, String apellidoM, String rut, String nombreUsuario, String password);

    /**
     * Registra una pelicula indicando el id, nombre, nombre del director, un tipo de género, un segundo tipo de
     * género (si lo tiene), la duración en horas y los minutos, el año de estreno y el stock disponible en tienda.
     *
     * @param id        Valor correlativo e identifica a una pelicula registrada, este valor es unico.
     * @param nombre    Nombre de la pelicula.
     * @param director  Nombre del director de la pelicula
     * @param genero1   Genero asociado a la pelicula, requerido.
     * @param genero2   Segundo genero asociado a la pelicula, en caso de no existir debe ser null
     * @param horas     Duración de la pelicula considerando solo las horas, por ejemplo si la pelicula dura 1 Hora
     *                  y 20 minutos, este parametro debe ser 1.
     * @param minutos   Duración de la pelicula considerando solo los minutos, por ejemplo si la pelicula dura 1 Hora
     *                  y 20 minutos, este parametro debe ser 20. Debe ser mayor que 0 si la cantidad de horas es 0.
     * @param anio      Año en el cual fue estrenada la pelicula
     * @param stock     indica la cantidad de peliculas que pueden ser ofrecidos para ser comprados.
     * @return boolean de valor true si el registro se efectuo exitosamente, en caso contrario regresa un false
     * si el registro no fue realizado.
     */
    boolean registrarPelicula(int id, String nombre, String director, String genero1, String genero2, int horas, int minutos, int anio, int stock);

    /**
     * Registra un libro indicando el id, título, autor, un tipo de género, un segundo tipo de género (si lo tiene),
     * la cantidad de páginas, el año de publicación, y el stock disponible en tienda.
     *
     * @param id       Valor correlativo e identifica a un libro registrado, es valor es unico.
     * @param titulo   Título que representa la temática del libro.
     * @param autor    Nombre del autor asociado al libro.
     * @param genero1  Genero asociado al libro
     * @param genero2  Segundo genero asociado al libro, en caso de no existir debe ser null
     * @param paginas  Cantidad de paginas que contiene el libro, debe ser mayor que 0.
     * @param anio     Año en que el libro fue publicado
     * @param stock    indica la cantidad de libros que pueden ser ofrecidos para ser comprados.
     * @return boolean de valor true si el registro se efectuo exitosamente, en caso contrario regresa un false
     * si el registro no fue realizado.
     */
    boolean registrarLibro(int id, String titulo, String autor,String genero1, String genero2, int paginas, int anio, int stock);

    /**
     * Permite que un usuario registrado en el sistema, pueda ingresar al sistema mediante un sistema de inicio de
     * sesión que requiere un nombre de usuario y una contraseña. Tanto el nombre de usuario y la contraseña deben
     * existir y a su vez deben estar relacionadas.
     *
     * @param nombreUsuario  Nombre de usuario del usuario que pretende ingresar al sistema.
     * @param password       Clave o contraseña asociado al nombre de usuario.
     * @return boolean de valor true si el inicio de sesión se efectuo exitosamente y existe un usuario logueado, en
     * caso contrario regresa un false debido a estas posibles causas.
     *      - El nombre de usuario no existe
     *      - La contraseña ingresada no esta asociada al nombre de usuario.
     */
    boolean iniciarSesion(String nombreUsuario, String password);

    /**
     * Permite al usuario arrendar una pelicula o un libro que este disponible. Es requisito que el usuario no tenga
     * devoluciones pendientes. En caso de que el usuario tenga una membresia VIP, no debe tener dos arriendos sin
     * entregar como maximo.
     *
     * Tanto el libro como la pelicula deben tener stock disponible para efectuar la acción y el usuario debe estar
     * logueado.
     *
     * @param nombreUsuario  Nombre del usuario que solicita el servicio de arrendar una pelicula o libro.
     * @param id  Numero que identifica al libro dentro del registro del sistema.
     * @return boolean de valor true si la accion de arrendar es efectuado correctamente. En caso contrario, regresa
     * un false que indica que la accion de arrendar ha fallado.
     */
    boolean arredarProducto(String nombreUsuario, int id);

    /**
     * Permite al usuario devolver algún producto que este posea previamente arrendado, para efectuar esta acción es
     * necesario que el usuario este logueado.
     *
     * En caso de efectuar la devolucion, se actualiza el stock del tipo producto asociado.
     *
     * @param nombreUsuario  Nombre del usuario que solicita el servicio de devolver una pelicula o libro, previamente
     *                       prestado.
     * @param titulo  Titulo del libro o pelicula asociado.
     * @return boolean de valor true si la devolución se efectuo correctamente. En caso contrario, regresa un false que
     * indica que la accion de devolucion ha fallado.
     */
    boolean devolverProducto(String nombreUsuario, String titulo);

    /**
     * Despliega los datos del usuario logueado dentro del sistema.
     *
     * @return Cadenas de String que contiene en cada posicion un dato asociado al usuario logueado.
     */
    String[] consultarDatos();

    /**
     * Permite al usuario logueado subir su membresia actual.
     *
     * @return boolean de valor true si el cambio de membresia se realizo exitosamente. En caso contrario, regresa un
     * false indicando que no fue posible subir la membresia.
     */
    boolean subirMembresia();

    /**
     * Permite al usuario logueado cambiar su contraseña actual.
     *
     * Para efectuar el cambio se debe considerar las siguientes validaciones.
     *     - La nueva contraseña debe ser distinta a la anterior.
     *     - La nueva contraseña debe tener como minimo 6 caracteres.
     *     - La nueva contraseña debe tener al menos una mayuscula.
     *     - La nueva contraseña debe tener como minimo un numero presente en la cadena.
     *
     * @param newPassword  valor de clave que reemplazar a la contraseña actual del usuario logueado.
     * @return boolean de valor True si la contraseña del usuario logueado fue cambiada exitosamente. En caso contrario,
     * regresa un false indicando que el cambio no fue realizado.
     */
    boolean cambiarPassword(String newPassword);

    /**
     * Despliega el catalogo de libros y peliculas.
     *
     * El usuario debe estar logueado.
     *
     * @param tipo: Puede ser libros o peliculas. Dependiendo del valor obtendra el catalogo del tipo de producto que
     *            corresponda.
     *
     * @return Conjuntos de String que contiene los datos asociados.
     */
    String[] obtenerCatalogo(String tipo);

    /**
     * Despliega la cantidad de transacciones realizadas durante el año 2022. El total de transacciones corresponde
     * a la cantidad de prestamos más la cantidad de devoluciones.
     *
     * El usuario debe estar logueado.
     *
     * @return int que indica la cantidad de transacciones. Debe ser mayor que 0.
     */
    int cantidadTransacciones();

    /**
     * Despliega el nombre de usuario con mayor cantidad de libros arrendados en total. Si existe más de un usuario
     * que cumple esta condición, se deben desplegar todos ellos.
     *
     * El usuario debe estar loqueado.
     *
     * @return Conjunto de Strings que contiene los datos asociados de los usuarios que cumplen con la condicion.
     */
    String[] usuarioMasPrestamos();

    /**
     * Obtener las transacciones realizadas. EL usuario debe estar loqueado.
     *
     * @return Conjunto de Strings que contiene los datos asociados de las transacciones realizadas.
     */
    String[] obtenerTransacciones();
}
