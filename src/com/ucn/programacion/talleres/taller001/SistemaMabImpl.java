package com.ucn.programacion.talleres.taller001;


import ucn.ArchivoEntrada;
import ucn.In;
import ucn.Registro;
import ucn.StdOut;

import java.io.IOException;

public class SistemaMabImpl implements SistemaMab{
    private ListaUsuario usuarios;
    private ListaLibro libros;
    private ListaPelicula peliculas;
    private ListaTransaccion transacciones;
    private Usuario usuarioLogueado;

    public SistemaMabImpl() throws IOException {
        this.usuarios = new ListaUsuario();
        this.libros = new ListaLibro();
        this.peliculas = new ListaPelicula();
        this.transacciones = new ListaTransaccion();
        this.usuarioLogueado = null;
        this.cargarUsuarios();
        this.cargarLibros();
        this.cargarPeliculas();
    }

    void cargarUsuarios() throws IOException {
        ArchivoEntrada arch = new ArchivoEntrada("src/com/ucn/programacion/talleres/taller001/usuarios.txt");
        while (!arch.isEndFile()){
            Registro registro = arch.getRegistro();
            String nombre = registro.getString();
            String apellidoP = registro.getString();
            String apellidoM = registro.getString();
            String rut = registro.getString();
            String nombreUsuario = registro.getString();
            String password = registro.getString();
            String membresia = registro.getString();

            Usuario usuario = new Usuario(nombre, apellidoP, apellidoM, rut, nombreUsuario, password);
            if(membresia != null){
                usuario.setMembresia(membresia);
            }
            this.usuarios.agregarUsuario(usuario);
        }
        arch.close();
    }

    void cargarLibros() throws IOException{
        ArchivoEntrada arch = new ArchivoEntrada("src/com/ucn/programacion/talleres/taller001/libros.txt");
        String genero2;
        String cantPaginas;
        String anioPublicacion;
        String stock;
        while (!arch.isEndFile()){
            genero2 = null;
            Registro registro = arch.getRegistro();
            int id = registro.getInt();
            String titulo = registro.getString();
            String autor = registro.getString();
            String genero1 = registro.getString();
            cantPaginas = registro.getString();
            anioPublicacion = registro.getString();
            stock = registro.getString();

            int cantPaginasInt;
            int anioPublicacionInt;
            int stockInt;
            try{
                cantPaginasInt = Integer.parseInt(cantPaginas);
                anioPublicacionInt = Integer.parseInt(anioPublicacion);
                stockInt = Integer.parseInt(stock);
            }catch (Exception e){
                genero2 = cantPaginas;
                cantPaginasInt = Integer.parseInt(anioPublicacion);
                anioPublicacionInt = Integer.parseInt(stock);
                stockInt = registro.getInt();
            }
            Libro libro;
            if(genero2 == null){
                libro = new Libro(id, titulo, autor, genero1, cantPaginasInt, anioPublicacionInt, stockInt);
            }else{
                libro = new Libro(id, titulo, autor, genero1, genero2, cantPaginasInt, anioPublicacionInt, stockInt);
            }
            this.libros.agregarLibro(libro);
        }
        arch.close();
    }

    public void cargarPeliculas() throws IOException{
        ArchivoEntrada arch = new ArchivoEntrada("src/com/ucn/programacion/talleres/taller001/peliculas.txt");
        String genero2;
        String horas;
        String minutos;
        String anioEstreno;
        String stock;
        while (!arch.isEndFile()){
            genero2 = null;
            Registro registro = arch.getRegistro();
            int id = registro.getInt();
            String nombre = registro.getString();
            String director = registro.getString();
            String genero1 = registro.getString();
            horas = registro.getString();
            minutos = registro.getString();
            anioEstreno = registro.getString();
            stock = registro.getString();

            int horasInt;
            int minutosInt;
            int anioEstrenoInt;
            int stockInt;

            try{
                horasInt = Integer.parseInt(horas);
                minutosInt = Integer.parseInt(minutos);
                anioEstrenoInt = Integer.parseInt(anioEstreno);
                stockInt = Integer.parseInt(stock);
            }catch (Exception e){
                genero2 = horas;
                horasInt = Integer.parseInt(minutos);
                minutosInt = Integer.parseInt(anioEstreno);
                anioEstrenoInt = Integer.parseInt(stock);
                stockInt = registro.getInt();
            }
            Pelicula pelicula;
            if(genero2 == null){
                pelicula = new Pelicula(id, nombre, director, genero1, horasInt, minutosInt, anioEstrenoInt, stockInt);
            }else{
                pelicula = new Pelicula(id, nombre, director, genero1, genero2, horasInt, minutosInt, anioEstrenoInt, stockInt);
            }
            this.peliculas.agregarPelicula(pelicula);
        }
        arch.close();
    }

    public boolean contieneMayuscula(String value){
        for (String character: value.split("")){
            if(character.equals(character.toUpperCase())){
                return true;
            }
        }
        return false;
    }

    public boolean contieneNumero(String value){
        for(int i=0; i < value.length(); i++){
            if(Character.isDigit(value.charAt(i))){
                return true;
            }
        }
        return false;
    }

    /**
     * Registra un usuario indicando su nombre, apellido paterno, apellido materno, rut, nombre de usuario y clave. El
     * usuario  no debe estar repetido y además cada usuario nuevo no tendrá ninguna membresía asignada.
     *
     * @param nombre        nombre con el cual se identifica la persona.
     * @param apellidoP     apellido paterno con el cual se identifica la persona.
     * @param apellidoM     apellido materno con el cual se identifica la persona.
     * @param rut           numero de registro unico tributario la cual se identifica a la persona y es unico.
     * @param nombreUsuario nombre de usuario que elige el usuario para ser identificado dentro del sistema.
     * @param password      conjunto de caracteres que permite loguear al usuario de manera segura.
     * @return boolean de valor true si el registro de usuario se efectuo exitosamente, en caso contrario regresa
     * un false si el registro no fue realizado.
     */
    @Override
    public boolean registrarUsuario(String nombre, String apellidoP, String apellidoM, String rut, String nombreUsuario, String password) {
        Usuario usuario = new Usuario(nombre, apellidoP, apellidoM, rut, nombreUsuario, password);
        for(int i=0; i < this.usuarios.getCantActual(); i++){
            if(this.usuarios.getUsuario(i).getRut().equals(usuario.getRut())){
                return false;
            }
        }
        return this.usuarios.agregarUsuario(usuario);
    }

    /**
     * Registra una pelicula indicando el id, nombre, nombre del director, un tipo de género, un segundo tipo de
     * género (si lo tiene), la duración en horas y los minutos, el año de estreno y el stock disponible en tienda.
     *
     * @param id       Valor correlativo e identifica a una pelicula registrada, este valor es unico.
     * @param nombre   Nombre de la pelicula.
     * @param director Nombre del director de la pelicula
     * @param genero1  Genero asociado a la pelicula, requerido.
     * @param genero2  Segundo genero asociado a la pelicula, en caso de no existir debe ser null
     * @param horas    Duración de la pelicula considerando solo las horas, por ejemplo si la pelicula dura 1 Hora
     *                 y 20 minutos, este parametro debe ser 1.
     * @param minutos  Duración de la pelicula considerando solo los minutos, por ejemplo si la pelicula dura 1 Hora
     *                 y 20 minutos, este parametro debe ser 20. Debe ser mayor que 0 si la cantidad de horas es 0.
     * @param anio     Año en el cual fue estrenada la pelicula
     * @param stock    indica la cantidad de peliculas que pueden ser ofrecidos para ser comprados.
     * @return boolean de valor true si el registro se efectuo exitosamente, en caso contrario regresa un false
     * si el registro no fue realizado.
     */
    @Override
    public boolean registrarPelicula(int id, String nombre, String director, String genero1, String genero2, int horas, int minutos, int anio, int stock) {
        return false;
    }

    /**
     * Registra un libro indicando el id, título, autor, un tipo de género, un segundo tipo de género (si lo tiene),
     * la cantidad de páginas, el año de publicación, y el stock disponible en tienda.
     *
     * @param id      Valor correlativo e identifica a un libro registrado, es valor es unico.
     * @param titulo  Título que representa la temática del libro.
     * @param autor   Nombre del autor asociado al libro.
     * @param genero1 Genero asociado al libro
     * @param genero2 Segundo genero asociado al libro, en caso de no existir debe ser null
     * @param paginas Cantidad de paginas que contiene el libro, debe ser mayor que 0.
     * @param anio    Año en que el libro fue publicado
     * @param stock   indica la cantidad de libros que pueden ser ofrecidos para ser comprados.
     * @return boolean de valor true si el registro se efectuo exitosamente, en caso contrario regresa un false
     * si el registro no fue realizado.
     */
    @Override
    public boolean registrarLibro(int id, String titulo, String autor, String genero1, String genero2, int paginas, int anio, int stock) {
        return false;
    }

    /**
     * Permite que un usuario registrado en el sistema, pueda ingresar al sistema mediante un sistema de inicio de
     * sesión que requiere un nombre de usuario y una contraseña. Tanto el nombre de usuario y la contraseña deben
     * existir y a su vez deben estar relacionadas.
     *
     * @param nombreUsuario Nombre de usuario del usuario que pretende ingresar al sistema.
     * @param password      Clave o contraseña asociado al nombre de usuario.
     * @return boolean de valor true si el inicio de sesión se efectuo exitosamente y existe un usuario logueado, en
     * caso contrario regresa un false debido a estas posibles causas.
     * - El nombre de usuario no existe
     * - La contraseña ingresada no esta asociada al nombre de usuario.
     */
    @Override
    public boolean iniciarSesion(String nombreUsuario, String password) {
        for(int i = 0; i < this.usuarios.getCantActual(); i++){
            if(this.usuarios.getUsuario(i).getNombreUsuario().equals(nombreUsuario) &&
            this.usuarios.getUsuario(i).getPassword().equals(password)){
                this.usuarioLogueado = this.usuarios.getUsuario(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Permite al usuario arrendar una pelicula o un libro que este disponible. Es requisito que el usuario no tenga
     * devoluciones pendientes. En caso de que el usuario tenga una membresia VIP, no debe tener dos arriendos sin
     * entregar como maximo.
     * <p>
     * Tanto el libro como la pelicula deben tener stock disponible para efectuar la acción y el usuario debe estar
     * logueado.
     *
     * @param nombreUsuario Nombre del usuario que solicita el servicio de arrendar una pelicula o libro.
     * @param id            Numero que identifica al libro dentro del registro del sistema.
     * @return boolean de valor true si la accion de arrendar es efectuado correctamente. En caso contrario, regresa
     * un false que indica que la accion de arrendar ha fallado.
     */
    @Override
    public boolean arredarProducto(String nombreUsuario, int id) {
        return false;
    }

    /**
     * Permite al usuario devolver algún producto que este posea previamente arrendado, para efectuar esta acción es
     * necesario que el usuario este logueado.
     * <p>
     * En caso de efectuar la devolucion, se actualiza el stock del tipo producto asociado.
     *
     * @param nombreUsuario Nombre del usuario que solicita el servicio de devolver una pelicula o libro, previamente
     *                      prestado.
     * @param titulo        Titulo del libro o pelicula asociado.
     * @return boolean de valor true si la devolución se efectuo correctamente. En caso contrario, regresa un false que
     * indica que la accion de devolucion ha fallado.
     */
    @Override
    public boolean devolverProducto(String nombreUsuario, String titulo) {
        return false;
    }

    /**
     * Despliega los datos del usuario logueado dentro del sistema.
     *
     * @return Cadenas de String que contiene en cada posicion un dato asociado al usuario logueado.
     */
    @Override
    public String[] consultarDatos() {
        if(usuarioLogueado == null) {
            return null;
        }
        return new String[]{
                this.usuarioLogueado.getNombre(),
                this.usuarioLogueado.getApellidoP(),
                this.usuarioLogueado.getApellidoM(),
                this.usuarioLogueado.getRut(),
                this.usuarioLogueado.getNombreUsuario(),
                this.usuarioLogueado.getMembresia()
        };
    }

    /**
     * Permite al usuario logueado subir su membresia actual.
     *
     * @return boolean de valor true si el cambio de membresia se realizo exitosamente. En caso contrario, regresa un
     * false indicando que no fue posible subir la membresia.
     */
    @Override
    public boolean subirMembresia() {
        return false;
    }

    /**
     * Permite al usuario logueado cambiar su contraseña actual.
     * <p>
     * Para efectuar el cambio se debe considerar las siguientes validaciones.
     * - La nueva contraseña debe ser distinta a la anterior.
     * - La nueva contraseña debe tener como minimo 6 caracteres.
     * - La nueva contraseña debe tener al menos una mayuscula.
     * - La nueva contraseña debe tener como minimo un numero presente en la cadena.
     *
     * @param newPassword valor de clave que reemplazar a la contraseña actual del usuario logueado.
     * @return boolean de valor True si la contraseña del usuario logueado fue cambiada exitosamente. En caso contrario,
     * regresa un false indicando que el cambio no fue realizado.
     */
    @Override
    public boolean cambiarPassword(String newPassword) {
        if(this.usuarioLogueado != null){
            String oldPassword = this.usuarioLogueado.getPassword();
            boolean cumpleCondiciones = !oldPassword.equals(newPassword) && newPassword.length() >= 6 &&
                    this.contieneMayuscula(newPassword) && this.contieneNumero(newPassword);
            if(cumpleCondiciones){
                this.usuarioLogueado.setPassword(newPassword);
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    /**
     * Despliega el catalogo de libros y peliculas.
     * <p>
     * El usuario debe estar logueado.
     *
     * @param tipo: Puede ser libros o peliculas. Dependiendo del valor obtendra el catalogo del tipo de producto que
     *            corresponda.
     *
     * @return Conjuntos de String que contiene los datos asociados.
     */
    @Override
    public String[] obtenerCatalogo(String tipo) {
        int contador = 0;

        if (tipo.equals("libros")){
            String [] msg = new String[this.libros.getCantActual()];
            Libro libro;
            for(int i=0; i < this.libros.getCantActual(); i++) {
                libro = this.libros.obtenerLibro(i);
                String formatoGenero = libro.getFirstGenero();
                if (libro.getSecondGenero() != null) {
                    formatoGenero += "/" + libro.getSecondGenero();
                }
                String formatoLibro = "Tipo: libro\n" +
                        "*******************************************************************\n" +
                        "Id: " + libro.getId() + ".\n" +
                        "Título: " + libro.getTitulo() + ".\n" +
                        "Autor: " + libro.getAutor() + ".\n" +
                        "Géneros: " + formatoGenero + ".\n" +
                        "Cantidad de páginas: " + libro.getCantPaginas() + ".\n" +
                        "Año publicación: " + libro.getAnioPubl() + ".\n" +
                        "Stock disponible: " + libro.getStock() + ".\n" +
                        "*******************************************************************\n";
                msg[contador] = formatoLibro;
                contador++;
            }
            return msg;
        }else if(tipo.equals("peliculas")){
            String [] msg = new String[this.peliculas.getCantActual()];
            Pelicula pelicula;
            for(int i=0; i < this.peliculas.getCantActual(); i++) {
                pelicula = this.peliculas.obtenerPelicula(i);
                String formatoGenero = pelicula.getFirstGenero();
                if (pelicula.getSecondGenero() != null) {
                    formatoGenero = formatoGenero + "/" + pelicula.getSecondGenero();
                }
                String formatoPelicula = "Tipo: película\n" +
                        "*******************************************************************\n" +
                        "Id: " + pelicula.getId() + ".\n" +
                        "Nombre: " + pelicula.getNombre() + ".\n" +
                        "Director: " + pelicula.getDirector() + ".\n" +
                        "Géneros: " + formatoGenero + ".\n" +
                        "Duración: " + (pelicula.getMinutos() + pelicula.getHoras() * 60) + " minutos.\n" +
                        "Año estreno: " + pelicula.getAnioEstreno() + ".\n" +
                        "Stock disponible: " + pelicula.getStock() + ".\n" +
                        "*******************************************************************\n";
                msg[contador] = formatoPelicula;
                contador++;
            }
            return msg;
        }else{
            return new String[0];
        }
    }

    /**
     * Despliega la cantidad de transacciones realizadas durante el año 2022. El total de transacciones corresponde
     * a la cantidad de prestamos más la cantidad de devoluciones.
     * <p>
     * El usuario debe estar logueado.
     *
     * @return int que indica la cantidad de transacciones. Debe ser mayor que 0.
     */
    @Override
    public int cantidadTransacciones() {
        return 0;
    }

    /**
     * Despliega el nombre de usuario con mayor cantidad de libros arrendados en total. Si existe más de un usuario
     * que cumple esta condición, se deben desplegar todos ellos.
     * <p>
     * El usuario debe estar loqueado.
     *
     * @return Conjunto de Strings que contiene los datos asociados de los usuarios que cumplen con la condicion.
     */
    @Override
    public String[] usuarioMasPrestamos() {
        return new String[0];
    }

    /**
     * Obtener las transacciones realizadas. EL usuario debe estar loqueado.
     *
     * @return Conjunto de Strings que contiene los datos asociados de las transacciones realizadas.
     */
    @Override
    public String[] obtenerTransacciones() {
        return new String[0];
    }
}
