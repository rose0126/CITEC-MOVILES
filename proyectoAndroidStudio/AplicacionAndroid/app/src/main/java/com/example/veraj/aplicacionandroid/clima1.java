package com.example.veraj.aplicacionandroid;

/**
 * Created by Alice on 04/02/2016.
 */
public class clima1 {
    String WeatherText;
    Integer WeatherIcon;
    temperature Temperature;

    public String getWeatherText() {
        return WeatherText;
    }

    public void setWeatherText(String weatherText) {
        WeatherText = weatherText;
    }

    public Integer getWeatherIcon() {
        return WeatherIcon;
    }

    public void setWeatherIcon(Integer weatherIcon) {
        WeatherIcon = weatherIcon;
    }

    public temperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(temperature temperature) {
        Temperature = temperature;
    }

    public class temperature{
        metric Metric;
        imperial Imperial;

        public metric getMetric() {
            return Metric;
        }

        public void setMetric(metric metric) {
            Metric = metric;
        }

        public imperial getImperial() {
            return Imperial;
        }

        public void setImperial(imperial imperial) {
            Imperial = imperial;
        }

        public class metric{
            public Double getValue() {
                return Value;
            }

            public void setValue(Double value) {
                Value = value;
            }

            public String getUnit() {
                return Unit;
            }

            public void setUnit(String unit) {
                Unit = unit;
            }

            Double Value;
            String Unit;
        }

        public class imperial{
            Double Value;
            String Unit;

            public Double getValue() {
                return Value;
            }

            public void setValue(Double value) {
                Value = value;
            }

            public String getUnit() {
                return Unit;
            }

            public void setUnit(String unit) {
                Unit = unit;
            }
        }
    }




}
