import org.example.provider.ConvertEuro;
import org.example.provider.ConvertDollar;
import org.example.provider.ConvertYen;
import org.example.service.CurrencyConverter;

module org.example.provider {
    requires org.example.service;
    provides org.example.service.CurrencyConverter with ConvertEuro, ConvertDollar, ConvertYen;
}