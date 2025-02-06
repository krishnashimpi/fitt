let currentInterface = 1;
let userData = {
  gender: null,
  dob: null,
  weight: null,
  height: null,
};

// Function to switch between interfaces
function nextInterface() {
  const currentElement = document.getElementById(interface${currentInterface});
  const nextElement = document.getElementById(interface${currentInterface + 1});
  
  if (currentElement && nextElement) {
    currentElement.classList.remove('active');
    currentInterface++;
    nextElement.classList.add('active');
  } else {
    console.error("Invalid interface transition");
  }
}

// Function to select gender
function selectGender(gender) {
  if (gender === 'male' || gender === 'female') {
    userData.gender = gender;
    nextInterface();
  } else {
    console.error("Invalid gender selection");
  }
}

// Function to calculate weight and height difference
function calculateDifference() {
  if (!userData.weight || !userData.height || !userData.gender) {
    console.error("Missing user data for calculation");
    return;
  }
  
  const idealWeight = userData.gender === 'male' ? 70 : 60; // Example ideal weights
  const idealHeight = userData.gender === 'male' ? 175 : 165; // Example ideal heights

  const weightDiff = userData.weight - idealWeight;
  const heightDiff = userData.height - idealHeight;

  const weightDiffElement = document.getElementById('weightDifference');
  const heightDiffElement = document.getElementById('heightDifference');
  
  if (weightDiffElement && heightDiffElement) {
    weightDiffElement.textContent = Weight Difference: ${weightDiff} kg;
    heightDiffElement.textContent = Height Difference: ${heightDiff} cm;
  } else {
    console.error("Weight/Height difference elements not found");
  }
}

// Function to generate meal plan
function generateMealPlan() {
  const mealPlanElement = document.getElementById('mealPlan');
  if (!mealPlanElement) {
    console.error("Meal plan element not found");
    return;
  }
  
  const mealPlan = `
    <h3>Breakfast</h3>
    <p>8:00 AM - 1 cup oatmeal cooked in 2 cups water+1/2 cup raspberries+1 Tbsp. chopped walnuts+1 hard-boiled egg+Top oatmeal with raspberries, walnuts and a pinch of cinnamon.
</p>
    <h3>Mid-Day Meal</h3>
    <p>11:00 AM - 1 medium apple+2 Tbsp. peanut butter
</p>
    <h3>Lunch</h3>
    <p>1:00 PM - 1 serving Whole-Wheat Veggie Wrap+1 banana</p>
    <h3>Evening Snack</h3>
    <p>4:00 PM - 1 cup nonfat plain Greek yogurt+1/2 cup sliced strawberries+1 Tbsp. chia seeds
</p>
    <h3>Dinner</h3>
    <p>7:00 PM - 1 serving Mushroom-Quinoa Veggie Burgers with Special Sauce+1 serving Basic Green Salad with Vinaigrette</p>
  `;
  mealPlanElement.innerHTML = mealPlan;
}

// Event listeners for input fields
document.getElementById('dob')?.addEventListener('change', (e) => {
  userData.dob = e.target.value;
});

document.getElementById('weight')?.addEventListener('input', (e) => {
  const weight = parseFloat(e.target.value);
  if (!isNaN(weight) && weight > 0) {
    userData.weight = weight;
  } else {
    console.error("Invalid weight input");
  }
});

document.getElementById('height')?.addEventListener('input', (e) => {
  const height = parseFloat(e.target.value);
  if (!isNaN(height) && height > 0) {
    userData.height = height;
  } else {
    console.error("Invalid height input");
  }
});

// Final step: Show meal plan
document.getElementById('interface5')?.querySelector('button')?.addEventListener('click', () => {
  calculateDifference();
  generateMealPlan();
});
