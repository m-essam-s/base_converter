import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:base_converter/themes/theme_notifier.dart';

import 'package:base_converter/models/binary.dart';
import 'package:base_converter/models/decimal.dart';
import 'package:base_converter/models/hexadecimal.dart';
import 'package:base_converter/models/octal.dart';

class ConverterWidget extends StatefulWidget {
  const ConverterWidget({super.key});

  @override
  State<ConverterWidget> createState() => _ConverterWidgetState();
}

class _ConverterWidgetState extends State<ConverterWidget> {
  List<String> list = const <String>[
    'Decimal',
    'Binary',
    'Hexadecimal',
    'Octal',
  ];
  String dropdownValueFrom = "Decimal";
  String dropdownValueTo = "Binary";

  final TextEditingController _controller = TextEditingController();
  String? _convertedValue;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        actions: [
          IconButton(
            icon: Icon(
              Provider.of<ThemeNotifier>(context).isDarkMode
                  ? Icons.light_mode
                  : Icons.dark_mode,
            ),
            onPressed: () {
              Provider.of<ThemeNotifier>(context, listen: false).toggleTheme();
            },
          ),
        ],
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: Text(
          'Base Converter',
          style: Theme.of(context).textTheme.headlineSmall,
        ),
      ),
      body: LayoutBuilder(
        builder: (context, constraints) {
          bool isWideScreen = constraints.maxWidth > 600;

          return SingleChildScrollView(
            child: Padding(
              padding: const EdgeInsets.all(16.0),
              child: Center(
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.stretch,
                  children: <Widget>[
                    TextFormField(
                      controller: _controller,
                      decoration: const InputDecoration(
                        border: OutlineInputBorder(),
                        hintText: 'Enter a number',
                        labelText: 'Input',
                      ),
                      keyboardType: TextInputType.number,
                      onChanged: _convertNumber,
                    ),
                    const SizedBox(height: 20),
                    isWideScreen
                        ? buildWideScreenDropdowns()
                        : buildCompactDropdowns(),
                    const SizedBox(height: 20),
                    // ElevatedButton(
                    //   onPressed: () => _convertNumber(_controller.text),
                    //   child: Text('Convert'),
                    // ),
                    const SizedBox(height: 20),
                    Container(
                      padding: const EdgeInsets.all(16.0),
                      decoration: BoxDecoration(
                        border: Border.all(color: Colors.deepPurpleAccent),
                        borderRadius: BorderRadius.circular(8.0),
                      ),
                      child: Text(
                        _convertedValue ?? 'Converted number will appear here.',
                        style: Theme.of(context).textTheme.headlineSmall,
                        textAlign: TextAlign.center,
                      ),
                    ),
                  ],
                ),
              ),
            ),
          );
        },
      ),
    );
  }

  Widget buildWideScreenDropdowns() {
    return Row(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Expanded(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text('Convert From:',
                  style: Theme.of(context).textTheme.bodyMedium),
              DropdownButton<String>(
                value: dropdownValueFrom,
                icon: const Icon(Icons.arrow_downward),
                elevation: 16,
                style: const TextStyle(color: Colors.deepPurple),
                underline: Container(
                  height: 2,
                  color: Colors.deepPurpleAccent,
                ),
                onChanged: (String? value) {
                  setState(() {
                    dropdownValueFrom = value!;
                    _convertNumber(_controller.text);
                  });
                },
                items: list.map<DropdownMenuItem<String>>((String value) {
                  return DropdownMenuItem<String>(
                    value: value,
                    child: Text(value),
                  );
                }).toList(),
              ),
            ],
          ),
        ),
        const SizedBox(width: 20),
        Expanded(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text('Convert To:',
                  style: Theme.of(context).textTheme.bodyMedium),
              DropdownButton<String>(
                value: dropdownValueTo,
                icon: const Icon(Icons.arrow_downward),
                elevation: 16,
                style: const TextStyle(color: Colors.deepPurple),
                underline: Container(
                  height: 2,
                  color: Colors.deepPurpleAccent,
                ),
                onChanged: (String? value) {
                  setState(() {
                    dropdownValueTo = value!;
                    _convertNumber(_controller.text);
                  });
                },
                items: list.map<DropdownMenuItem<String>>((String value) {
                  return DropdownMenuItem<String>(
                    value: value,
                    child: Text(value),
                  );
                }).toList(),
              ),
            ],
          ),
        ),
      ],
    );
  }

  Widget buildCompactDropdowns() {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text('Convert From:', style: Theme.of(context).textTheme.bodyMedium),
        DropdownButton<String>(
          value: dropdownValueFrom,
          icon: const Icon(Icons.arrow_downward),
          elevation: 16,
          style: const TextStyle(color: Colors.deepPurple),
          underline: Container(
            height: 2,
            color: Colors.deepPurpleAccent,
          ),
          onChanged: (String? value) {
            setState(() {
              dropdownValueFrom = value!;
              _convertNumber(_controller.text);
            });
          },
          items: list.map<DropdownMenuItem<String>>((String value) {
            return DropdownMenuItem<String>(
              value: value,
              child: Text(value),
            );
          }).toList(),
        ),
        const SizedBox(height: 20),
        Text('Convert To:', style: Theme.of(context).textTheme.bodyMedium),
        DropdownButton<String>(
          value: dropdownValueTo,
          icon: const Icon(Icons.arrow_downward),
          elevation: 16,
          style: const TextStyle(color: Colors.deepPurple),
          underline: Container(
            height: 2,
            color: Colors.deepPurpleAccent,
          ),
          onChanged: (String? value) {
            setState(() {
              dropdownValueTo = value!;
              _convertNumber(_controller.text);
            });
          },
          items: list.map<DropdownMenuItem<String>>((String value) {
            return DropdownMenuItem<String>(
              value: value,
              child: Text(value),
            );
          }).toList(),
        ),
      ],
    );
  }

  void _convertNumber(String input) {
    if (input.isEmpty) {
      setState(() {
        _convertedValue = 'Enter a valid number';
      });
      return;
    }

    String result;
    try {
      switch (dropdownValueFrom) {
        case 'Decimal':
          switch (dropdownValueTo) {
            case 'Decimal':
              result = input;
              break;
            case 'Binary':
              result = Decimal.toBinary(input);
              break;
            case 'Hexadecimal':
              result = Decimal.toHexadecimal(input);
              break;
            case 'Octal':
              result = Decimal.toOctal(input);
              break;
            default:
              result = 'Unknown conversion';
          }
          break;
        case 'Binary':
          switch (dropdownValueTo) {
            case 'Decimal':
              result = Binary.toDecimal(input);
              break;
            case 'Binary':
              result = input;
              break;
            case 'Hexadecimal':
              result = Binary.toHexadecimal(input);
              break;
            case 'Octal':
              result = Binary.toOctal(input);
              break;
            default:
              result = 'Unknown conversion';
          }
          break;
        case 'Octal':
          switch (dropdownValueTo) {
            case 'Decimal':
              result = Octal.toDecimal(input);
              break;
            case 'Binary':
              result = Octal.toBinary(input);
              break;
            case 'Octal':
              result = input;
              break;
            case 'Hexadecimal':
              result = Octal.toHexadecimal(input);
              break;
            default:
              result = 'Unknown conversion';
          }
          break;
        case 'Hexadecimal':
          switch (dropdownValueTo) {
            case 'Decimal':
              result = Hexadecimal.toDecimal(input);
              break;
            case 'Binary':
              result = Hexadecimal.toBinary(input);
              break;
            case 'Octal':
              result = Hexadecimal.toOctal(input);
              break;
            case 'Hexadecimal':
              result = input;
              break;
            default:
              result = 'Unknown conversion';
          }
          break;
        default:
          result = 'Unknown conversion';
      }
    } catch (e) {
      result = 'Invalid input';
    }

    setState(() {
      _convertedValue = result;
    });
  }
}
