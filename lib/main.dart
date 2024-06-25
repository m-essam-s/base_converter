import 'package:base_converter/widgets/converter_widget.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:base_converter/themes/theme_notifier.dart';
import 'package:base_converter/themes/theme.dart';

void main() {
  runApp(
    ChangeNotifierProvider(
      create: (_) => ThemeNotifier(),
      child: const MyApp(),
    ),
  );
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    final themeNotifier = Provider.of<ThemeNotifier>(context);

    return MaterialApp(
      debugShowCheckedModeBanner: false,
      theme: lightTheme,
      darkTheme: darkTheme,
      themeMode: themeNotifier.isDarkMode ? ThemeMode.dark : ThemeMode.light,
      home: const ConverterWidget(),
    );
  }
}
