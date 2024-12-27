import tkinter as tk
from tkinter import ttk, messagebox

class CentroMedicoApp:
    def __init__(self, root):
        self.root = root
        self.root.title("Sistema Centro Médico")
        self.root.geometry("1000x700")
        self.root.configure(bg="#f0f8ff")

        self.create_widgets()

    def create_widgets(self):
        # Frame for Welcome Page
        self.welcome_frame = tk.Frame(self.root, bg="#f0f8ff")
        self.welcome_frame.pack(fill="both", expand=True)

        welcome_label = tk.Label(self.welcome_frame, text="¡Bienvenido al Sistema del Centro Médico!", 
                                  font=("Helvetica", 24, "bold"), bg="#f0f8ff", fg="#2c3e50")
        welcome_label.pack(pady=20)

        developers_label = tk.Label(self.welcome_frame, text="Desarrollado por: Equipo XYZ", 
                                     font=("Helvetica", 14), bg="#f0f8ff", fg="#7f8c8d")
        developers_label.pack(pady=10)

        start_button = tk.Button(self.welcome_frame, text="Comenzar", font=("Helvetica", 16), bg="#3498db", fg="white", 
                                  relief="flat", command=self.show_main_interface)
        start_button.pack(pady=20)

        # Main Notebook (Hidden at Start)
        self.tab_control = ttk.Notebook(self.root)

        # Tabs
        self.tab_usuarios = ttk.Frame(self.tab_control)
        self.tab_servicios = ttk.Frame(self.tab_control)
        self.tab_citas = ttk.Frame(self.tab_control)
        self.tab_clientes = ttk.Frame(self.tab_control)
        self.tab_facturas = ttk.Frame(self.tab_control)

        self.tab_control.add(self.tab_usuarios, text="Usuarios")
        self.tab_control.add(self.tab_servicios, text="Servicios")
        self.tab_control.add(self.tab_citas, text="Citas")
        self.tab_control.add(self.tab_clientes, text="Clientes")
        self.tab_control.add(self.tab_facturas, text="Facturas")

        # Populate each tab
        self.create_usuarios_tab()
        self.create_servicios_tab()
        self.create_citas_tab()
        self.create_clientes_tab()
        self.create_facturas_tab()

    def show_main_interface(self):
        self.welcome_frame.destroy()
        self.tab_control.pack(expand=1, fill="both")

    def create_usuarios_tab(self):
        lbl = tk.Label(self.tab_usuarios, text="Gestión de Usuarios", font=("Arial", 16, "bold"), bg="#ecf0f1", fg="#2c3e50")
        lbl.pack(pady=10, fill="x")

        tk.Label(self.tab_usuarios, text="Nombre:", font=("Arial", 12), bg="#ecf0f1", fg="#2c3e50").pack(pady=5)
        tk.Entry(self.tab_usuarios).pack(pady=5)
        
        tk.Label(self.tab_usuarios, text="Rol (Admin/General):", font=("Arial", 12), bg="#ecf0f1", fg="#2c3e50").pack(pady=5)
        tk.Entry(self.tab_usuarios).pack(pady=5)
        
        ttk.Button(self.tab_usuarios, text="Agregar Usuario", command=self.add_user).pack(pady=5)

    def create_servicios_tab(self):
        lbl = tk.Label(self.tab_servicios, text="Gestión de Servicios", font=("Arial", 16, "bold"), bg="#ecf0f1", fg="#2c3e50")
        lbl.pack(pady=10, fill="x")

        tk.Label(self.tab_servicios, text="Código del Servicio:", font=("Arial", 12), bg="#ecf0f1", fg="#2c3e50").pack(pady=5)
        tk.Entry(self.tab_servicios).pack(pady=5)
        
        tk.Label(self.tab_servicios, text="Nombre del Servicio:", font=("Arial", 12), bg="#ecf0f1", fg="#2c3e50").pack(pady=5)
        tk.Entry(self.tab_servicios).pack(pady=5)

        tk.Label(self.tab_servicios, text="Precio:", font=("Arial", 12), bg="#ecf0f1", fg="#2c3e50").pack(pady=5)
        tk.Entry(self.tab_servicios).pack(pady=5)

        tk.Label(self.tab_servicios, text="IVA (Sí/No):", font=("Arial", 12), bg="#ecf0f1", fg="#2c3e50").pack(pady=5)
        tk.Entry(self.tab_servicios).pack(pady=5)

        ttk.Button(self.tab_servicios, text="Agregar Servicio", command=self.add_service).pack(pady=5)

    def create_citas_tab(self):
        lbl = tk.Label(self.tab_citas, text="Gestión de Citas", font=("Arial", 16, "bold"), bg="#ecf0f1", fg="#2c3e50")
        lbl.pack(pady=10, fill="x")

        tk.Label(self.tab_citas, text="Paciente:", font=("Arial", 12), bg="#ecf0f1", fg="#2c3e50").pack(pady=5)
        tk.Entry(self.tab_citas).pack(pady=5)

        tk.Label(self.tab_citas, text="Médico:", font=("Arial", 12), bg="#ecf0f1", fg="#2c3e50").pack(pady=5)
        tk.Entry(self.tab_citas).pack(pady=5)

        tk.Label(self.tab_citas, text="Fecha y Hora:", font=("Arial", 12), bg="#ecf0f1", fg="#2c3e50").pack(pady=5)
        tk.Entry(self.tab_citas).pack(pady=5)

        ttk.Button(self.tab_citas, text="Registrar Cita", command=self.register_appointment).pack(pady=5)

    def create_clientes_tab(self):
        lbl = tk.Label(self.tab_clientes, text="Gestión de Clientes", font=("Arial", 16, "bold"), bg="#ecf0f1", fg="#2c3e50")
        lbl.pack(pady=10, fill="x")

        tk.Label(self.tab_clientes, text="Cédula:", font=("Arial", 12), bg="#ecf0f1", fg="#2c3e50").pack(pady=5)
        tk.Entry(self.tab_clientes).pack(pady=5)

        tk.Label(self.tab_clientes, text="Nombres:", font=("Arial", 12), bg="#ecf0f1", fg="#2c3e50").pack(pady=5)
        tk.Entry(self.tab_clientes).pack(pady=5)

        tk.Label(self.tab_clientes, text="Apellidos:", font=("Arial", 12), bg="#ecf0f1", fg="#2c3e50").pack(pady=5)
        tk.Entry(self.tab_clientes).pack(pady=5)

        tk.Label(self.tab_clientes, text="Dirección:", font=("Arial", 12), bg="#ecf0f1", fg="#2c3e50").pack(pady=5)
        tk.Entry(self.tab_clientes).pack(pady=5)

        tk.Label(self.tab_clientes, text="Teléfono:", font=("Arial", 12), bg="#ecf0f1", fg="#2c3e50").pack(pady=5)
        tk.Entry(self.tab_clientes).pack(pady=5)

        tk.Label(self.tab_clientes, text="Correo Electrónico:", font=("Arial", 12), bg="#ecf0f1", fg="#2c3e50").pack(pady=5)
        tk.Entry(self.tab_clientes).pack(pady=5)

        ttk.Button(self.tab_clientes, text="Agregar Cliente", command=self.add_client).pack(pady=5)

    def create_facturas_tab(self):
        lbl = tk.Label(self.tab_facturas, text="Gestión de Facturas", font=("Arial", 16, "bold"), bg="#ecf0f1", fg="#2c3e50")
        lbl.pack(pady=10, fill="x")

        tk.Label(self.tab_facturas, text="Número de Factura:", font=("Arial", 12), bg="#ecf0f1", fg="#2c3e50").pack(pady=5)
        tk.Entry(self.tab_facturas).pack(pady=5)

        tk.Label(self.tab_facturas, text="Paciente:", font=("Arial", 12), bg="#ecf0f1", fg="#2c3e50").pack(pady=5)
        tk.Entry(self.tab_facturas).pack(pady=5)

        tk.Label(self.tab_facturas, text="Usuario que Generó la Factura:", font=("Arial", 12), bg="#ecf0f1", fg="#2c3e50").pack(pady=5)
        tk.Entry(self.tab_facturas).pack(pady=5)

        tk.Label(self.tab_facturas, text="Subtotal:", font=("Arial", 12), bg="#ecf0f1", fg="#2c3e50").pack(pady=5)
        tk.Entry(self.tab_facturas).pack(pady=5)

        tk.Label(self.tab_facturas, text="Valor Total IVA:", font=("Arial", 12), bg="#ecf0f1", fg="#2c3e50").pack(pady=5)
        tk.Entry(self.tab_facturas).pack(pady=5)

        tk.Label(self.tab_facturas, text="Valor Total Factura:", font=("Arial", 12), bg="#ecf0f1", fg="#2c3e50").pack(pady=5)
        tk.Entry(self.tab_facturas).pack(pady=5)

        ttk.Button(self.tab_facturas, text="Generar Factura", command=self.generate_invoice).pack(pady=5)

    # Placeholder methods for actions
    def add_user(self):
        messagebox.showinfo("Usuarios", "Función para agregar usuario")

    def add_service(self):
        messagebox.showinfo("Servicios", "Función para agregar servicio")

    def register_appointment(self):
        messagebox.showinfo("Citas", "Función para registrar cita")

    def add_client(self):
        messagebox.showinfo("Clientes", "Función para agregar cliente")

    def generate_invoice(self):
        messagebox.showinfo("Facturas", "Función para generar factura")

if __name__ == "__main__":
    root = tk.Tk()
    app = CentroMedicoApp(root)
    root.mainloop()
  