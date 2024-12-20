const int ledExterno = 13;   // LED externo conectado al pin 13
const int pulsador = 2;      // Pulsador conectado al pin 2

int estadoPulsador = HIGH;   // Estado actual del pulsador
int estadoAnterior = HIGH;   // Estado previo del pulsador
bool estadoLED = false;      // Estado del LED (false = apagado, true = encendido)

void setup() {
  pinMode(ledExterno, OUTPUT);      // Configuración del LED externo
  pinMode(pulsador, INPUT_PULLUP);  // Pulsador con resistencia pull-up interna
  digitalWrite(ledExterno, LOW);    // Asegura que el LED comience apagado
}

void loop() {
  // Lectura del estado del pulsador
  estadoPulsador = digitalRead(pulsador);

  // Detecta el cambio de estado del pulsador: LOW significa pulsado
  if (estadoPulsador == LOW && estadoAnterior == HIGH) {
    estadoLED = !estadoLED;  // Cambia el estado del LED (toggle)
    delay(50);               // Debouncing para evitar lecturas múltiples
  }

  // Guarda el estado del pulsador actual para la siguiente iteración
  estadoAnterior = estadoPulsador;

  // Aplica el estado al LED externo
  digitalWrite(ledExterno, estadoLED ? HIGH : LOW);
}
