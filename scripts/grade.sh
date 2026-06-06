#!/usr/bin/env bash
set -euo pipefail

MODE="${1:-}"
if [[ -z "$MODE" ]]; then
  echo "Uso: bash scripts/grade.sh <ex1|ex2|ex3|ex4|ex5|ex6>"
  exit 1
fi

echo "Compilando arquivos..."
mkdir -p bin
javac -d bin src/App.java autograde/Autograder.java

echo "Executando teste para $MODE..."
java -cp bin autograde.Autograder "$MODE"

echo "Teste concluido com sucesso!"
