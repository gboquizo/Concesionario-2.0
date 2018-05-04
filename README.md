<h1>Concesionario de coches con Ficheros y GUI</h1>
Sobre la versión anterior del Concesionario de coches con excepciones del siguiente repositorio,crea otra versión 
añadiéndole tanto Ficheros<br/ > como el entorno gráfico para la comunicación con el usuario.Nos fijaremos en el Notepad para hacerlo lo más parecido posible.<br/ >
Con respecto a los ficheros:
<ul>
	<ol>
		<li>Añade un menú Archivo</li>
		<li>Tendrá las opciones típicas: nuevo, abrir, guardar,guardar como...</li>
		<li>El concesionario podrá guardarse en un fichero (guardar y guardar como...)</li>
		<li>El concesionario podrá leerse de un fichero (abrir)</li>
		<li>Podrá crearse un concesionario nuevo (nuevo)
		<li>En caso de que se pueda perder información del concesionario, se le
			preguntará al usuario (nuevo, abrir, guardar como...)</li>
		<li>Se le añadirá la extensión ".obj". Deberás utilizar la clase File, que es
			una representación abstracta de los nombres de los ficheros y<br/ >
			directorios.Podrás usar los métodos:
			<ol>
			 	<li>File file = new File(String pathname)</li>
				<li>file.getPath();</li>
				<li>file.exists();</li>
			</ol>
		</li>
	</ol>
</ul>	
PD: Utiliza el ARM para evitar el tener que utilizar el close() de los flujos<br />
PPD: Procura colocar la creación del flujo en la misma línea, evitando el uso de variables innecesarias.<br />
Con respecto al GUI:
<ul>
	<li>Paquetes. Deberás olvidarte del paquete utiles. Necesitas un paquete sólo para el GUI, 
		donde tendrás la clase Principal.java que abrirá la ventana principal.Recuerda que las excepciones han de estar en el 		paquete que las crean.</li>
	<li>La página principal tendrá como título el fichero abierto ("Sin título" en caso de no tener asociado ningún fichero). 
	Será al estilo del Notepad.</li>
	<li>Una barra de menú (JMenuBar) con los siguientes menús (JMenu):
		<ul>
			<li>Ficheros</li>
			<li>Coches</li>
			<li>Ayuda</li>
		</ul>
		<p>Tendrá las teclas de acceso rápido asociadas a cada elemento del menú,así como mnemotécnicos.
		Añade también separadores entre elementos del menú.<br />
		Será al estilo del Notepad. (como en el recurso de los alumnos Juan Antonio Romero y Elisa Navarro)</p>
	</li>
	<li>Un diálogo para trabajar con ficheros (JFileChooser). Ha de usar un filtro para visualizar los ficheros con 	extensión".obj"</li>
	<li>Un diálogo para trabajar con Coches (JDialog).El diálogo contendrá:
		<ul>
			<li>Una caja de texto (JTextField) debidamente etiquetada(JLabel) para las matrículas Al perder el foco cambiará el 				color si la matrícula no es válida.Al editar, la matrícula siempre lo hará en negro.</li>
			<li>Una lista (JList) para el modelo y otra para la marca. Las listas han de estar sincronizadas</li>.
			<li>Tres radio buttons con los tres colores (tres JRadioButton y un ButtonGroup)</li>
				<ul>
					<li>Selecciona los tres, menú contextual > set ButtonGroup</li>
				</ul>
			<li>con un borde etiquetado Color</li>
				<ul>
 					<li>Selecciona los tres, menú contextual > Surround with > javax.swing.JPanel border) y </li>
 				</ul>
 			<li>Botones (JButton) para Salir o realizar la acción (crear, eliminar, mostrar...).</li>
 		</ul>
	<li>Los mensajes de error (JOptionPane) han de ser lo más conciso posible.</li>
	<li>Quizás deban basarse en el atributo message de las excepciones.</li>
	<li>El menú ayuda dispondrá de un Ver ayuda y Acerca de...</li>
</ul>
@author Guillermo Boquizo Sánchez<p>
@version 1.0