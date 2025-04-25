SRC_DIR = src
Bin_DIR = bin
PACKAGE = sim 

SOURCES := $(wildcard $(SRC_DIR)/$(PACKAGE)/*.java)

compile:
	mkdir -p build $(BIN_DIR)
	javac -d build $(BIN_DIR) $(SOURCES)

run: compile
	java -cp $(BIN_DIR) $(PACKAGE).Main

clean:
	rm -rf $(BIN_DIR)
