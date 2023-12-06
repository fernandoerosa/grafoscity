## Testando a API
### Teste 1: Calcular a rota de CityA para CityF com uma motocicleta

```bash
curl -X GET "http://localhost:PORT/city/calc?source=CityA&destination=CityF&vehicleCode=M"
```

**Valor JSON Esperado:**
```json
{
  "track": "[CityA, CityB, CityD, CityF]",
  "kmValue": "9",
  "tollValue": "8",
  "fuelValue": "9",
  "trackTime (h)": "8"
}
```

### Teste 2: Calcular a rota de CityB para CityD com um carro

```bash
curl -X GET "http://localhost:PORT/city/calc?source=CityB&destination=CityD&vehicleCode=C"
```

**Valor JSON Esperado:**
```json
{
  "track": "[CityB, CityA, CityC, CityE, CityF, CityD]",
  "kmValue": "14",
  "tollValue": "4",
  "fuelValue": "42",
  "trackTime (h)": "17"
}
```

### Teste 3: Calcular a rota de CityC para CityE com um ônibus

```bash
curl -X GET "http://localhost:PORT/city/calc?source=CityC&destination=CityE&vehicleCode=B"
```

**Valor JSON Esperado:**
```json
{
  "track": "[CityC, CityA, CityB, CityE]",
  "kmValue": "14",
  "tollValue": "8",
  "fuelValue": "70",
  "trackTime (h)": "11"
}
```

### Teste 4: Calcular a rota de CityD para CityF com um caminhão

```bash
curl -X GET "http://localhost:PORT/city/calc?source=CityD&destination=CityF&vehicleCode=T"
```

**Valor JSON Esperado:**
```json
{
  "track": "[CityD, CityF]",
  "kmValue": "7",
  "tollValue": "4",
  "fuelValue": "56",
  "trackTime (h)": "4"
}
```

### Notas:
- Substitua "PORT" pela porta em que a sua aplicação está sendo executada.