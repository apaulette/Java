function populateNewSelects(value) {
    var unitFrom = document.getElementById("unitFrom");
    var unitTo = document.getElementById("unitTo");
    
    // Clear all existing dropdown options first:
    unitFrom.innerHTML = "";
    unitTo.innerHTML = "";
    // One day I will learn multi-dimensional arrays. Today is not that day.
    if (value === "Area") {
        var optionArray = ["Square Meter", "Hectare", "Square Inch", "Square Foot", "Square Mile", "Acre"];
    }
    if (value === "Length") {
        var optionArray = ["Millimeter", "Centimeter", "Meter", "Kilometer", "Inch", "Foot", "Yard", "Mile"];
    }
    if (value === "Mass") {
        var optionArray = ["Milligram", "Gram", "Kilogram", "Ounce", "Pound", "Stone"];
    }
    if (value === "Temperature") {
        var optionArray = ["Celsius", "Fahrenheit", "Kelvin"];
    }
    if (value === "Volume") {
        var optionArray = ["Milliliter", "Liter", "US Fluid Ounce", "US Cup", "US Pint", "US Quart", "US Gallon"];
    }
    
    // Populate selection dropdown with options:
    for(var i = 0; i < optionArray.length; i++) {
        var option = optionArray[i];
        unitFrom.innerHTML += "<option name=\"" + option + "\">" + option + "</option>";
        unitTo.innerHTML += "<option name=\"" + option + "\">" + option + "</option>";
    }
}