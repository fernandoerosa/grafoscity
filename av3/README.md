# Teste de API para o Controlador de Cidades

## Teste 1: Calcular distância entre CityA e CityF

```bash
curl -X GET "http://localhost:8080/city/calcular-distancia?source=CityA&destination=CityF"
```

**Resposta Esperada:**
```json
[
  {"name": "CityA"},
  {"name": "CityC"},
  {"name": "CityE"},
  {"name": "CityF"}
]
```

## Teste 2: Calcular distância entre CityB e CityD

```bash
curl -X GET "http://localhost:8080/city/calcular-distancia?source=CityB&destination=CityD"
```

**Resposta Esperada:**
```json
[
  {"name": "CityB"},
  {"name": "CityD"}
]
```

## Teste 3: Calcular distância entre CityC e CityF

```bash
curl -X GET "http://localhost:8080/city/calcular-distancia?source=CityC&destination=CityF"
```

**Resposta Esperada:**
```json
[
  {"name": "CityC"},
  {"name": "CityE"},
  {"name": "CityF"}
]
```

## Teste 4: Calcular distância entre CityD e CityE

```bash
curl -X GET "http://localhost:8080/city/calcular-distancia?source=CityD&destination=CityE"
```

**Resposta Esperada:**
```json
[
  {"name": "CityD"},
  {"name": "CityF"},
  {"name": "CityE"}
]
```

---
